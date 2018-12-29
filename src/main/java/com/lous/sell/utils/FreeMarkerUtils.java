package com.lous.sell.utils;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.TemplateHashModel;
import freemarker.template.Version;
import org.springframework.ui.Model;

/**
 * @ClassName : FreeMarkerUtils
 * @Description : 在FreeMarker 文件中访问 java静态方法和静态变量
 *
 * @author : Loushuai
 * @since : 2018-12-29
 **/
 
public abstract class FreeMarkerUtils {

    public static void initStatics(final Model model){
        BeansWrapper wrapper = new BeansWrapper(new Version(2, 3, 27));
        TemplateHashModel staticModels = wrapper.getStaticModels();
        model.addAttribute("statics", staticModels);
    }

}
