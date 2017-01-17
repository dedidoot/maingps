# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /home/robby/android-sdks/sdks/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
 # proguard green dao https://github.com/greenrobot/greenDAO/issues/367

-keep class com.squareup.** { *; }
-keep interface com.squareup.** { *; }
-dontwarn com.squareup.okhttp.**

-keep interface com.squareup.okhttp.** { *; }
-keep class com.squareup.okhttp.** { *; }

-keep class retrofit.** { *; }
-keep class retrofit.http.** { *; }
-keep class retrofit.client.** { *; }

-keepattributes Signature
-keep class sun.misc.Unsafe { *; }


-keep interface retrofit.** { *;}
-keep interface com.squareup.** { *; }
-keep class twitter4j.* { *; }
-dontwarn rx.*
-dontwarn retrofit.**
-dontwarn okio.**
-dontwarn twitter4j.**
-keep class com.facebook.** { *; }
-keepattributes Exceptions

-keepclasseswithmembers class * {
    @retrofit.http.* <methods>;
}

-keepattributes *Annotation*

-dontwarn java.nio.file.Files
-dontwarn java.nio.file.Path
-dontwarn java.nio.file.OpenOption
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn android.support.v4.**

-dontwarn com.google.**
-keep class com.google.analytics.tracking.android.** { *; }

-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.onImageDownloaded.resource.bitmap.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
}

-dontwarn org.greenrobot.greendao.database.**

-keepclassmembers class * extends de.greenrobot.dao.AbstractDao {
    public static java.lang.String TABLENAME;
}
-keep class **$Properties


# Google Play Services library
-keep class * extends java.util.ListResourceBundle {
    protected Object[][] getContents();
}

-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
    public static final *** NULL;
}

-keepnames @com.google.android.gms.common.annotation.KeepName class *

-keepclassmembernames class * {
    @com.google.android.gms.common.annotation.KeepName *;
}

-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}


-keep public class com.google.android.gms.analytics.** { *; }
-keep public class android.support.v7.widget.** { *; }
-keep public class android.support.v7.internal.widget.** { *; }
-keep public class android.support.v7.internal.view.menu.** { *; }
-keep public class android.os.UserManager.** { *; }

-keep public class * extends android.support.v4.view.ActionProvider {
    public <init>(android.content.Context);
}

-keepclassmembers enum * {
public static **[] values();
public static ** valueOf(java.lang.String);
}

# Agar kompatibel support design
-dontwarn android.support.design.**
-keep class android.support.design.** { *; }
-keep interface android.support.design.** { *; }
-keep public class android.support.design.R$* { *; }

# Agar kompatibel support v4 dan v7
-dontwarn android.support.**
-keep class android.support.v4.** { *; }
-keep class android.support.v7.** { *; }

# Agar support CoordinatorLayout
-keep public class * extends android.support.design.widget.CoordinatorLayout$Behavior {
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>();
}

# Agar support Twitter4j library
-keep class twitter4j.conf.PropertyConfigurationFactory
-dontwarn twitter4j.**

# EventBus ====================
-keepattributes *Annotation*
-keepclassmembers class ** {
    @org.greenrobot.eventbus.Subscribe <methods>;
}
-keep enum org.greenrobot.eventbus.ThreadMode { *; }

# Only required if you use AsyncExecutor
-keepclassmembers class * extends org.greenrobot.eventbus.util.ThrowableFailureEvent {
    <init>(java.lang.Throwable);
}


# retorfit 2
-dontwarn retrofit2.**
-dontwarn org.codehaus.mojo.**
-keep class retrofit2.** { *; }
-keepattributes Signature
-keepattributes Exceptions
-keepattributes *Annotation*

-keepattributes RuntimeVisibleAnnotations
-keepattributes RuntimeInvisibleAnnotations
-keepattributes RuntimeVisibleParameterAnnotations
-keepattributes RuntimeInvisibleParameterAnnotations

-keepattributes EnclosingMethod

-keepclasseswithmembers class * {
    @retrofit2.* <methods>;
}

-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform
# Platform used when running on RoboVM on iOS. Will not be used at runtime.
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.Platform$Java8
# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature
# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions

#RXJAVA
# RxJava 0.21
-keep class rx.schedulers.Schedulers {
    public static <methods>;
}
-keep class rx.schedulers.ImmediateScheduler {
    public <methods>;
}
-keep class rx.schedulers.TestScheduler {
    public <methods>;
}
-keep class rx.schedulers.Schedulers {
    public static ** test();
}
-dontwarn sun.misc.Unsafe


