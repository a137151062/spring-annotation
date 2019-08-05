package com.lihegang.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑返回需要导入的组件
 * Created by dong-er on 2019-08-05.
 */
public class MyImportSelector implements ImportSelector {


    /**
     * 返回值，就是要导入到容器中组件的全类名
     * @param annotationMetadata：当前标注@Import注解的类的所有注解信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        // 不能返回null，否则会报空指针异常
        return new String[]{"com.lihegang.bean.Blue","com.lihegang.bean.Yellow"};
    }
}
