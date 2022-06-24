package com.unittest.abhi.unittest1.business;


import com.unittest.abhi.unittest1.data.DataService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//Not needed since this is not the right approach
class BusinessImplStubTestData implements DataService {

    @Override
    public int[] retreiveAllData() {
        return new int[] {1,2,3};
    }
}

class DataServiceEmptyStub implements DataService {

    @Override
    public int[] retreiveAllData() {
        return new int[] {};
    }
}

class DataServiceOneStub implements DataService {

    @Override
    public int[] retreiveAllData() {
        return new int[] {3};
    }
}

