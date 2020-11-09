package com.leanmentors.martianrobots;

import org.junit.Test;
import static com.leanmentors.martianrobots.Orientation.*;

import static org.assertj.core.api.Assertions.assertThat;

public class OrientationTest {

    @Test
    public void testRotateLeft(){
        assertThat(E.rotateLeft()).isEqualTo(N);
        assertThat(N.rotateLeft()).isEqualTo(W);
        assertThat(W.rotateLeft()).isEqualTo(S);
        assertThat(S.rotateLeft()).isEqualTo(E);
    }

    @Test
    public void testRotateRight(){
        assertThat(E.rotateRight()).isEqualTo(S);
        assertThat(S.rotateRight()).isEqualTo(W);
        assertThat(W.rotateRight()).isEqualTo(N);
        assertThat(N.rotateRight()).isEqualTo(E);
    }
}
