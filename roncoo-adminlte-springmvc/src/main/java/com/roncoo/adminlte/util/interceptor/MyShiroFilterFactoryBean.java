package com.roncoo.adminlte.util.interceptor;

import com.roncoo.adminlte.bean.entity.TSysResource;
import com.roncoo.adminlte.bean.vo.Result;
import com.roncoo.adminlte.service.SysResourceService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * roncoo-adminlte-springmvc
 *
 * @Description: 资源权限初始化，但此扩展不具备权限资源更新能力，因此系统数据库中权限授权变更后需重启系统
 * @Author: Andrew(andrew_luo@foxmail.com)
 * @Date: 2017/11/1 21:37
 */
public class MyShiroFilterFactoryBean extends ShiroFilterFactoryBean {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysResourceService resourceService;

    /**
     * 项目基础路径
     */
    @Value("#{configProperties['basePath']}")
    private String basePath;

    @Override
    public void setFilterChainDefinitionMap(Map<String, String> filterChainDefinitionMap) {
        if (filterChainDefinitionMap != null) {
            //增加读取数据库动态资源权限
            filterChainDefinitionMap.putAll(buildFilterChainDefinitionMap());
        }
        super.setFilterChainDefinitionMap(filterChainDefinitionMap);
    }

    /**
     * 权限初始化
     *
     * @return 返回权限集合
     */
    public LinkedHashMap<String, String> buildFilterChainDefinitionMap() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        Result<List<TSysResource>> result = resourceService.list();
        if (result.isStatus()) {
            for (TSysResource resource : result.getResultData()) {
                if (resource.getFstatus() == 0) {
                    continue;
                }
                if (StringUtils.isEmpty(resource.getFresUrl()) || StringUtils.isEmpty(resource.getFpermissionValue())) {
                    logger.warn("resource url or permission value is null, resource info >> id:{},resName:{}, resUrl:{}, resPermission:{}", resource.getFid(), resource.getFresName(), resource.getFresUrl(), resource.getFpermissionValue());
                    continue;
                }
                String permissionValue = "authcBasic,perms[" + resource.getFpermissionValue() + "]";
                map.put(basePath + resource.getFresUrl(), permissionValue);
            }
            logger.info("resource list: {}", map);
        }
        return map;
    }
}
