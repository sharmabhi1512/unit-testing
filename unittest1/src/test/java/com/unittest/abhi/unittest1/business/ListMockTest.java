package com.unittest.abhi.unittest1.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List mock = mock(List.class);
    List<String> mock2 = mock(List.class);
    //basic with collection
    @Test
    public void sizeBasic() {

        when(mock.size()).thenReturn(5);
        Assertions.assertEquals(5, mock.size());
    }

    @Test
    public void returnDifferentSize() {
        when(mock.size()).thenReturn(5).thenReturn(10);
        Assertions.assertEquals(5, mock.size());
        Assertions.assertEquals(10, mock.size());
    }

    @Test
    public void returnWithParameter() {
        when(mock.get(0)).thenReturn("Abhi");
        Assertions.assertEquals("Abhi", mock.get(0));
    }

    @Test
    public void returnWithGenericParameter() {
        when(mock.get(anyInt())).thenReturn("Abhi");
        Assertions.assertEquals("Abhi", mock.get(0));
        Assertions.assertEquals("Abhi", mock.get(1));
    }

    @Test
    public void verificationBasics(){
        String value1 = mock2.get(0);
        verify(mock2).get(0);
        verify(mock2).get(anyInt());
        verify(mock2, times(1)).get(anyInt());
    }

    @Test
    public void verificationBasics2(){
        String value1 = mock2.get(0);
        String value2 = mock2.get(1);
        verify(mock2).get(0);
        verify(mock2, times(2)).get(anyInt());
        verify(mock2, atLeast(1)).get(anyInt());
        verify(mock2, atLeastOnce()).get(anyInt());
        verify(mock2, atMost(2)).get(anyInt());
        verify(mock2, never()).get(2);
    }

    @Test
    public void argumentCapturing() {
        mock.add("Something");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        Assertions.assertEquals("Something", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        mock.add("Something1");
        mock.add("Something2");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());
        List<String> values = captor.getAllValues();
        Assertions.assertEquals("Something1", values.get(0));
        Assertions.assertEquals("Something2", values.get(1));
    }

    @Test
    public void mocking() {
        ArrayList list = mock(ArrayList.class);
        list.get(0);
        System.out.println(list.size());
        list.add("test");
        list.add("test2");
        when(list.size()).thenReturn(5);
        System.out.println(list.size());
    }

    @Test
    public void spying() {
        ArrayList list = spy(ArrayList.class);
        list.add("Abhi");
        list.get(0);
        System.out.println(list.size());
        list.add("test");
        list.add("test2");
        when(list.size()).thenReturn(5);
        System.out.println(list.size());
        verify(list).add("test2");
    }
}
