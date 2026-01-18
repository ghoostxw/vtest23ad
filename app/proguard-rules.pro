# ProGuard rules for the v2ray-adguard-android application

# Keep the classes and methods used for reflection
-keep class com.example.v2rayadguard.** { *; }

# Keep the ViewModel classes
-keep class * extends androidx.lifecycle.ViewModel { *; }

# Keep the Parcelable classes
-keepclassmembers class * implements android.os.Parcelable {
    public static final ** CREATOR;
    public *;
}

# Keep the classes used in the AndroidManifest.xml
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider

# Keep the classes used in the JNI
-keep class com.example.v2rayadguard.jni.** { *; }

# Keep the classes used for DNS and AdBlock
-keep class com.example.v2rayadguard.dns.** { *; }
-keep class com.example.v2rayadguard.adblock.** { *; }

# Keep the classes used for configuration import/export
-keep class com.example.v2rayadguard.config.** { *; }

# Keep the classes used for network statistics
-keep class com.example.v2rayadguard.util.NetworkStats { *; }

# Keep the classes used for logging
-keep class com.example.v2rayadguard.service.** { *; }

# Keep the classes used for UI components
-keep class com.example.v2rayadguard.ui.** { *; }

# Keep the classes used for Kotlin coroutines
-keep class kotlinx.coroutines.** { *; }

# Keep the classes used for Retrofit (if used)
-keep class retrofit2.** { *; }
-keep class okhttp3.** { *; }

# Keep the classes used for Gson (if used)
-keep class com.google.gson.** { *; }

# Keep the classes used for Room (if used)
-keep class androidx.room.** { *; }

# Keep the classes used for LiveData (if used)
-keep class androidx.lifecycle.LiveData { *; }

# Keep the classes used for Data Binding (if used)
-keep class androidx.databinding.** { *; }

# Keep the classes used for Material Components (if used)
-keep class com.google.android.material.** { *; }