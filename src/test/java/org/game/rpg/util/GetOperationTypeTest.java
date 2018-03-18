package org.game.rpg.util;

import org.assertj.core.api.Assertions;
import org.game.rpg.game.map.operation.Operation.OperationType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;

import static java.util.Arrays.asList;
import static org.game.rpg.game.map.operation.Operation.OperationType.*;

/**
 * Created by Amit Sharma on 3/16/2018.
 */
@RunWith(Parameterized.class)
public class GetOperationTypeTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return asList(new Object[] [] {
                {"1", RIGHT},
                {"2", LEFT},
                {"3", UP},
                {"4", DOWN},
                {"5", SAVE},
                {"6", EXIT}
        });
    }

    @Parameterized.Parameter
    public String userInput;

    @Parameterized.Parameter(1)
    public OperationType expectedOperationType;

    @Test
    public void getOperationTypeTest() throws Exception {
        //given
        final InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);

        //when
        final OperationType operationType = GameUtil.getOperationType();

        //then
        Assertions.assertThat(operationType).isEqualTo(expectedOperationType);
    }
}
