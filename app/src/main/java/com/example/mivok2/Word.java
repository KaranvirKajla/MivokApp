package com.example.mivok2;

public class Word {
    private String mDefaultTranslation;
    private String mMivokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mAudioResourceId;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word (String defaultTranslation, String miwokTranslation, int audioResourceId)
    {
        mDefaultTranslation = defaultTranslation;
        mMivokTranslation   = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

        public Word (String defaultTranslation, String miwokTranslation, int imageResourceId,int audioResourceId)
        {
            mDefaultTranslation = defaultTranslation;
            mMivokTranslation   = miwokTranslation;
            mImageResourceId = imageResourceId;
            mAudioResourceId = audioResourceId;
        }
    public String getmDefaultTranslation(){
        return mDefaultTranslation;
    }
    public String getmMivokTranslation(){
        return mMivokTranslation;
    }
    public int getImageResourceId(){return mImageResourceId;}
    public int getmAudioResourceId(){return mAudioResourceId;}
    public boolean hasImage(){
    return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
