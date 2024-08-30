package JMeter;

import org.apache.jmeter.samplers.SampleEvent;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.threads.JMeterContext;
import org.apache.jmeter.threads.JMeterVariables;

import java.io.PrintStream;
import java.util.Properties;
import java.util.logging.Logger;

public class JMeter {
    public BSH bsh;
    public Logger log;
    public SampleResult prev,Response,sampleResult,SampleResult;
    public SampleEvent sampleEvent;
    public boolean Failure;
    public String FailureMessage;
    public byte[] ResponseData;
    public int ResponseCode;
    public String ResponseMessage;

    public String ResponseHeaders;
    public String RequestHeaders;
    public String SampleLabel;
    public String SamplerData;

    public JMeterContext ctx;
    public JMeterVariables vars;
    public Properties props;

    public String Label;
    public String FileName;
    public String Parameters;
    public boolean IsSuccess;

    PrintStream OUT = System.out;
}
