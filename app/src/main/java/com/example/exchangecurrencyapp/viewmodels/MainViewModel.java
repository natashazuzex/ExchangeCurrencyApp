package com.example.exchangecurrencyapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.exchangecurrencyapp.utils.BureauDeChange;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    public MainViewModel() {
    }

    private MutableLiveData<String> finalAmountMutableLiveData;

    public LiveData<String> getFinalAmount() {
        if (finalAmountMutableLiveData == null) {
            finalAmountMutableLiveData = new MutableLiveData<>();
        }

        return finalAmountMutableLiveData;
    }

    public void onOkClicked(String from, String to, double sum) {
        Observable.just(BureauDeChange.currencyExchange(from, to, sum))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Double>() {
                               @Override
                               public void onSubscribe(@NonNull Disposable d) {
                               }

                               @Override
                               public void onNext(@NonNull Double aDouble) {
                                   finalAmountMutableLiveData.setValue(aDouble.toString());
                               }

                               @Override
                               public void onError(@NonNull Throwable e) {
                               }

                               @Override
                               public void onComplete() {
                               }
                           }
                );
    }
}
