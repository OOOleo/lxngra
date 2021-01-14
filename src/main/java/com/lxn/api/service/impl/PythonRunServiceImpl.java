package com.lxn.api.service.impl;

import com.lxn.api.service.PythonRunService;
import com.lxn.api.util.FilePathUtil;
import org.junit.Test;
import org.python.core.PyFunction;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.script.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Properties;

@Service
public class PythonRunServiceImpl implements PythonRunService {

    @Value("${file-location}")
    String fileAddress;

    @Override
    public double getPyResult(String filepath) {
        Object eval = null;
        try {
            FileReader fr =  new FileReader(filepath);
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("jython");
            eval = engine.eval(fr);
            fr.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Double.parseDouble(eval.toString());
    }


    private ScriptEngine engine = null;
    private Invocable invocableEngine = null;                    // 执行引擎
    private Compilable compEngine = null;                        // 编译引擎
    private Map<String, CompiledScript> compiledScripts = null;    // 编译的脚本
    private static String engineName = "jython";                // 脚本引擎
    public static final String SCRIPT_METHOD_NAME = "main"; // 方法
    private static ScriptEngineManager manager = new ScriptEngineManager();


    public void test() {
        engine = manager.getEngineByName(engineName);
        if (engine instanceof Invocable) {
            invocableEngine = (Invocable) engine;
        }
        if (engine instanceof Compilable) {
            compEngine = (Compilable) engine;
        }
        try {
            File configPath = FilePathUtil.getConfigPath("demo.py");
            CompiledScript cs = compEngine.compile(new FileReader(configPath));
            cs.eval();
            int d = 1;
            long avg = 0;
            int ct = 1;
            String funName = "sum";
            for (int k = 0; k < ct; k++) {
                long s1 = System.currentTimeMillis();
                for (int i = 0; i < d; i++) {
                    Object o = invocableEngine.invokeFunction(funName, new Object[]{1, 2});
                    System.out.println(o);
                }
                long s2 = System.currentTimeMillis();
                long result = s2 - s1;
                System.out.println("第" + k + "次耗时" + result);
                avg += result;
            }
            System.out.println(ct + "次中平均" + d + "次速度:" + avg / ct);
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
