package org.isaacsoriano.tests;
import org.junit.Test;

import java.io.Serializable;

import static org.assertj.core.api.Assertions.*;


public class MonetaryAmountTest {



    @Test
    public void value_test() {
        MonetaryAmount firstAmount = MonetaryAmount.of(3);
        double firstAmountValue = 3;

        assertThat(firstAmount.value()).isEqualTo(firstAmountValue);
    }

    @Test
    public void factory_test(){

        assertThatThrownBy(() -> MonetaryAmount.of(-2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("A monetary amount must be positive!");


        MonetaryAmount firstAmount = MonetaryAmount.of(2);
        assertThat(firstAmount.value()).isEqualTo(2);
    }

    @Test
    public void addition_test(){
        MonetaryAmount firstAmount = MonetaryAmount.of(2);
        MonetaryAmount secondAmount = MonetaryAmount.of(3);
        MonetaryAmount thirdAmount = MonetaryAmount.of(5);

        assertThat(firstAmount.add(secondAmount)).isEqualTo(thirdAmount);
    }

    @Test
    public void substraction_test(){

        MonetaryAmount firstAmount = MonetaryAmount.of(4);
        MonetaryAmount secondAmount = MonetaryAmount.of(5);

        assertThatThrownBy(() -> firstAmount.subtract(secondAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("You can't substract a greater monetary amount to a lesser monetary amoung!");


        MonetaryAmount thirdAmount = MonetaryAmount.of(4);
        MonetaryAmount fourthAmount = MonetaryAmount.of(2);
        MonetaryAmount fifthAmount = MonetaryAmount.of(2);

        assertThat(thirdAmount.subtract(fourthAmount)).isEqualTo(fifthAmount);
    }


}
