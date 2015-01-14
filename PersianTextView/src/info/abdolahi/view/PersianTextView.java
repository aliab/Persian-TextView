package info.abdolahi.view;

/*
 * Copyright (C) 2015 Ali Abdolahi
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file 
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the 
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions and 
 * limitations under the License.
 */

import info.abdolahi.persiantextview.R;
import info.abdolahi.persiantextview.R.styleable;
import info.abdolahi.utils.PersianReshape;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Subclass of {@link TextView} that supports the <code>customTypeface with Persian Reshaping for Android 2.3 and below</code>
 * attribute from XML.
 * 
 * @author Ali Abdolahi <i@abdolahi.info>
 */
public class PersianTextView extends TextView {

	/*
	 * Caches typefaces based on their file path and name, so that they don't
	 * have to be created every time when they are referenced.
	 */
	private static Map<String, Typeface> mTypefaces;

	public PersianTextView(final Context context) {
		this(context, null);
	}

	public PersianTextView(final Context context, final AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public PersianTextView(final Context context, final AttributeSet attrs,
			final int defStyle) {
		super(context, attrs, defStyle);
		if (mTypefaces == null) {
			mTypefaces = new HashMap<String, Typeface>();
		}

		// prevent exception in Android Studio / ADT interface builder
		if (this.isInEditMode()) {
			return;
		}

		final TypedArray array = context.obtainStyledAttributes(attrs, styleable.CustomTextView);
		if (array != null) {
			final String typefaceAssetPath = array.getString(R.styleable.CustomTextView_customFont);

			if (typefaceAssetPath != null) {
				Typeface typeface = null;

				if (mTypefaces.containsKey(typefaceAssetPath)) {
					typeface = mTypefaces.get(typefaceAssetPath);
				} else {
					AssetManager assets = context.getAssets();
					typeface = Typeface.createFromAsset(assets,
							typefaceAssetPath);
					mTypefaces.put(typefaceAssetPath, typeface);
				}

				setTypeface(typeface);
			}
			array.recycle();
		}
	}
	
	
	@Override
	public void setText(CharSequence text, BufferType type) {
		Locale current = getResources().getConfiguration().locale;
		if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB && !"fa".contains(current.getLanguage()))
			text = PersianReshape.reshape(String.valueOf(text));
		super.setText(text, type);
	}

}
