package org.apache.jmeter.functions;
import org.apache.jmeter.JMeter;
import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.junit.JMeterTestCase;
import org.apache.jmeter.threads.JMeterContext;
import org.apache.jmeter.threads.JMeterContextService;
import org.apache.jmeter.threads.JMeterVariables;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import static org.apache.jmeter.functions.FunctionTestHelper.makeParams;
import java.util.Collection;

public class IntThreeSumTest extends JMeterTestCase {
    @Test
    public void sumTest() throws Exception {
        IntThreeSum intThreeSum = new IntThreeSum();
        checkInvalidParameterCounts(intThreeSum,3); //检查一下参数最小入参3位
        Collection<CompoundVariable> params = makeParams("1","2","3");
        intThreeSum.setParameters(params);
        String totalString = intThreeSum.execute();
        System.out.println("total:" + totalString);
    }
}