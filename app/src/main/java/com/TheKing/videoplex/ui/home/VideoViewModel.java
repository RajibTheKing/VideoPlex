package com.TheKing.videoplex.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VideoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public VideoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Video fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}