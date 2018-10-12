package com.roncoo.adminlte.util;

import com.roncoo.adminlte.bean.entity.TSysResource;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 权限资源工具类
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/10/28 21:49
 */
public class ResourceUtil {

    /**
     * 获取父节点
     * @param treeList
     * @param parentId
     * @return
     */
    public static Map<String, Object> getParentNode(List<Map<String, Object>> treeList, long parentId) {
        for (Map<String, Object> node : treeList) {
            if (parentId == (long)node.get("id")) {
                return node;
            }

            if (node.containsKey("children")) {
                Map<String, Object> childNode = getParentNode((List<Map<String, Object>>) node.get("children"), parentId);
                if (childNode != null) {
                    return childNode;
                }
            }
        }
        return null;
    }

    /**
     * 设置父节点为显示
     *
     * @param treeList
     * @param parentId
     */
    public static void setParentShow(List<Map<String, Object>> treeList, long parentId) {
        Map<String, Object> parentNode = getParentNode(treeList, parentId);
        if (parentNode == null) {
            return;
        }
        parentNode.put("show", true);
        if (parentNode.containsKey("parentId")) {
            setParentShow(treeList, (long)parentNode.get("parentId"));
        }
    }

    /**
     * 封闭节点属性集合
     * @param resource 资源对象
     * @return 节点MAP属性集合
     */
    public static Map<String, Object> getMapNode(TSysResource resource) {
        Map<String, Object> node = new HashMap<String, Object>();
        node.put("id", resource.getFid());
        node.put("name", resource.getFresName());
        node.put("state", "open");
        node.put("resType", resource.getFresType());
        node.put("permissionValue", resource.getFpermissionValue());
        node.put("ico", resource.getFico());
        node.put("level", resource.getFlevel());
        node.put("url", resource.getFresUrl());
        if (StringUtils.isNotEmpty(resource.getFresDesc())) {
            node.put("rstDesc", resource.getFresDesc());
        }
        node.put("isLeaf", resource.getFisLeaf());
        node.put("parentId", resource.getFparentId());
        if (resource.getFisLeaf() == 0) {
            node.put("children", new ArrayList<Map<String, Object>>());
        }
        return node;
    }

    /**
     * 获取资源树集合
     *
     * @param allResource 资源列表
     * @param resourceIds 有权限查看的资源ID
     * @return 资源树集合
     */
    public static List<Map<String, Object>> getTreeList(List<TSysResource> allResource, Map<Long, Long> resourceIds) {
        List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>();
        for (TSysResource resource : allResource) {
            if (resource.getFstatus() == 0) {
                continue;
            }
            if (resource.getFresType().equalsIgnoreCase(Constants.ResourceType.LABEL)) {
                continue;
            }

            if (resource.getFparentId() == -1) {
                treeList.add(ResourceUtil.getMapNode(resource));
            } else {
                Map<String, Object> parentNode = ResourceUtil.getParentNode(treeList, resource.getFparentId());
                if (parentNode != null && parentNode.containsKey("children")) {
                    List<Map<String, Object>> childNodes = (List<Map<String, Object>>) parentNode.get("children");
                    Map<String, Object> childNode = ResourceUtil.getMapNode(resource);
                    childNodes.add(childNode);

                    //如果当前节点用户有权限访问，则增加标记
                    if (resourceIds != null && resourceIds.containsKey(resource.getFid())) {
                        childNode.put("show", true);
                        parentNode.put("show", true);
                        setParentShow(treeList, resource.getFparentId());
                    }
                    if (!resource.getFresType().equalsIgnoreCase(Constants.ResourceType.MENU)) {
                        //如果当前节点不是菜单节点，则标识父节点结束
                        parentNode.put("endMenu", true);
                    }
                }
            }
        }
        return treeList;
    }

    /**
     * 资源集合转DOM
     *
     * @param treeList 资源树集合
     * @param parentNode 父级节点
     * @param basePath 项目基础路径
     */
    public static Element treeToDom(List<Map<String, Object>> treeList, Element parentNode, String basePath) {
        if (parentNode == null) {
            Document document = DocumentHelper.createDocument();
            Element rootElement = document.addElement("ul");
            rootElement.addAttribute("class", "sidebar-menu");
            rootElement.addAttribute("data-widget", "tree");
            parentNode = rootElement;
        }

        for (Map<String, Object> node : treeList) {
            if (!node.get("resType").equals(Constants.ResourceType.MENU)) {
                continue;
            }
            if (!node.containsKey("show")) {
                continue;
            }

            //增加头部标签节点
            if (node.containsKey("rstDesc")) {
                Element header = parentNode.addElement("li");
                header.addAttribute("class", "header").setText((String) node.get("rstDesc"));
            }


            Element li = parentNode.addElement("li");
            //如果当前结点不是叶子节点，同时不是末级菜单，则循环拼装子菜单
            if ((int)node.get("isLeaf") == 0 && !node.containsKey("endMenu")) {
                //父节点
                li.addAttribute("class", "treeview");
                Element a = li.addElement("a");
                a.addAttribute("href", "javascript:void(0)");
                a.addElement("i").addAttribute("class", (String) node.get("ico")).setText(" ");
                a.addElement("span").setText((String)node.get("name"));
                Element icoNode = a.addElement("span").addAttribute("class", "pull-right-container");
                icoNode.addElement("i").addAttribute("class", "fa fa-angle-left pull-right").setText(" ");
                Element ul = li.addElement("ul");
                ul.addAttribute("class", "treeview-menu menu-open");
                treeToDom((List<Map<String, Object>>) node.get("children"), ul, basePath);
            } else {
                Element a = li.addElement("a").addAttribute("target", "navTab").addAttribute("href", basePath + (String) node.get("url"));
                a.addElement("i").addAttribute("class", (String) node.get("ico")).setText(" ");
                a.addElement("span").setText((String) node.get("name"));
            }
        }
        return parentNode;
    }

    /**
     * 获取菜单DOM
     *
     * @param allResource 资源列表
     * @param resourceIds 有权访问的资源ID
     * @return 菜单DOM字符串
     */
    public static String getMenuDom(List<TSysResource> allResource, Map<Long, Long> resourceIds, String basePath) {
        List<Map<String, Object>> treeList = getTreeList(allResource, resourceIds);
        return treeToDom(treeList, null, basePath).asXML();
    }
}
