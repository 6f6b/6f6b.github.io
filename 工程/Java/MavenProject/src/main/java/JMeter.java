import org.apache.jmeter.samplers.SampleEvent;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.threads.JMeterContext;
import org.apache.jmeter.threads.JMeterVariables;

import java.io.PrintStream;
import java.util.Properties;
import java.util.logging.Logger;

public class JMeter {
    BSH bsh;
    Logger log;
    SampleResult prev,Response,sampleResult,SampleResult;
    SampleEvent sampleEvent;
    boolean Failure;
    String FailureMessage;
    byte[] ResponseData;
    int ResponseCode;
    String ResponseMessage;

    String ResponseHeaders;
    String RequestHeaders;
    String SampleLabel;
    String SamplerData;

    JMeterContext ctx;
    JMeterVariables vars;
    Properties props;

    String Label;
    String FileName;
    String Parameters;
    boolean IsSuccess;

    PrintStream OUT = System.out;

    public void editShellHere(){
    }
}
