package com.petitchef.petitchef.network;

/**
 * Created by girard_s on 11/05/2016 for PetitChef
 */
public interface APIListener<T> {
    void onResult(T object);
}
