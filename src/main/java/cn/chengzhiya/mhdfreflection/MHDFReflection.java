package cn.chengzhiya.mhdfreflection;

import cn.chengzhiya.mhdfreflection.manager.ReflectionManager;
import lombok.Getter;

@Getter
public final class MHDFReflection {
    public static MHDFReflection instance;

    private final ReflectionManager reflectionManager;

    public MHDFReflection() {
        instance = this;
        this.reflectionManager = new ReflectionManager();
    }
}
