package org.apache.jmeter.functions;
import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;
import org.apache.jmeter.threads.JMeterVariables;
import org.apache.jmeter.util.JMeterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class IntThreeSum extends AbstractFunction {
    private static final Logger log = LoggerFactory.getLogger(IntThreeSum.class);
    private static final List<String> desc = new LinkedList<>();    //描述
    private static final String KEY = "__IntThreeSum";  //方法描述，必须双下划线
    static {
        desc.add(JMeterUtils.getResString("first_param"));
        desc.add(JMeterUtils.getResString("secone_param"));
        desc.add(JMeterUtils.getResString("third_param"));
    }
    private Object[] values;
    public IntThreeSum() {
    }
    @Override
    public String execute(SampleResult previousResult, Sampler currentSampler) throws InvalidVariableException {
        JMeterVariables vars = getVariables();
        int sum = 0;
        String varName = ((CompoundVariable) values[values.length - 1]).execute().trim();
        log.info("varName==>:{}", varName);
        //遍历获取3个数之和
        for (int i = 0; i < values.length - 1; i++) {
            sum += Integer.parseInt(((CompoundVariable) values[i]).execute());
        }
        try {
            sum += Integer.parseInt(varName);
            varName = null;
        } catch (NumberFormatException ignored) {
        }
        String totalString = Integer.toString(sum);
        if (vars != null && varName != null) {
            vars.put(varName.trim(), totalString);
            log.info("varName:", vars.get(varName.trim()));
        }
        return totalString;
    }
    @Override
    public void setParameters(Collection<CompoundVariable> parameters) throws InvalidVariableException {
        //对入参进行检查,最小3个参数
        checkMinParameterCount(parameters,3);
        values = parameters.toArray();
    }
    @Override
    public String getReferenceKey() {
        return KEY;
    }
    @Override
    public List<String> getArgumentDesc() {
        return desc;
    }
}
