package com.example.android.miwok;

/**
 * Created by Abhishek Prasad on 27-Jul-17.
 */
//Just verifying the collabration

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId;
    private int mAudioResourceId;

    public Word(String defaultTranslation,String miwokTranslation,int imageResource,int audioResource)
    {
        this.mDefaultTranslation=defaultTranslation;
        this.mMiwokTranslation=miwokTranslation;
        this.mImageResourceId=imageResource;
        this.mAudioResourceId=audioResource;
    }

    public Word(String defaultTranslation,String miwokTranslation,int audioResource)
    {
        this.mDefaultTranslation=defaultTranslation;
        this.mMiwokTranslation=miwokTranslation;
        this.mAudioResourceId=audioResource;
    }

    public String getMiwokTranslation()
    {
        return this.mMiwokTranslation;
    }
    public String getDefaultTranslation()
    {
        return this.mDefaultTranslation;
    }
    public int getImageResourceId(){ return this.mImageResourceId; }
    public int getAudioResourceId(){ return this.mAudioResourceId; }
}