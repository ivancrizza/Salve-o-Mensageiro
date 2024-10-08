# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Gson configurations
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}

-keepattributes Signature
-keepattributes *Annotation*

-keepclassmembers,allowobfuscation class * {
    ** fromJson(...);
    ** toJson(...);
}

-keep class com.google.gson.reflect.TypeToken {
    <init>(java.lang.reflect.Type);
}

-keep class * extends com.google.gson.reflect.TypeToken {
    <init>();
}

# Keep all Gson related classes
-keep class com.google.gson.** { *; }

# Keep OrixaResponse class and its fields
-keep class br.com.salveomensageiro.data.response.OrixaResponse { *; }

# Keep the repository implementation
-keep class br.com.salveomensageiro.domain.OrixaRepositoryImpl { *; }

# Keep the specific JSON assets handling in MainActivity
-keepclassmembers class br.com.salveomensageiro.ui.view.MainActivity {
    void onCreate(android.os.Bundle);
}

# Keep Retrofit interfaces
-keep interface br.com.salveomensageiro.data.api.** { *; }

# Keep data classes used with Retrofit
-keep class br.com.salveomensageiro.data.model.** { *; }