#Persian Reshape with Typeface TextView
----------------

Persian Reshape with Typeface TextView allows you to specify custom fonts right in the XML and avoids typeface 
creation boilerplate code with automatic Reshaping for andriod 2.3 and below (thanks to [@ragunathjawahar](https://github.com/ragunathjawahar)).

#Screenshot
![Preview](https://dl.dropboxusercontent.com/u/34047574/shot1_demo.png)
#Quick Start
-----------
**Step 1 - Add PersianTextView as a library project**

**Step 2 - Make the following changes to your XML layout**
```xml
<!-- 1. Add a custom namespace, xmlns:persianui -->
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:persianui="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <!-- 2. Replace <TextView> tags with <info.abdolahi.view.PersianTextView> tags -->
    <!-- 3. Specify the path to your custom font in the 'assets' folder
            using the 'persianui:customFont' attribute -->
    <info.abdolahi.view.PersianTextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/hello_world"
        persianui:customFont="byekan.ttf" />

</RelativeLayout>
```

License
-------

    Copyright 2015 Ali Abdolahi

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
