package com.ztesoft.web.command.demo5;

/**
 * 类描述：
 * @author: xu.xin
 * 
 *          History:2015  下午7:08:17 xu.xin Created.
 * 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




/**
 * Class responsible for pumping the streams of the subprocess
 * out to log. stderr is pumped to WARN level and stdout is
 * pumped to INFO level
 */
class StreamPumper {
  enum StreamType {
    STDOUT, STDERR;
  }

  private static Log log=LogFactory.getLog(StreamPumper.class); 
  
  final Thread thread;
  final String logPrefix;
  final StreamPumper.StreamType type;
  private final InputStream stream;
  private boolean started = false;
  
  StreamPumper(final Log log2, final String logPrefix,
      final InputStream stream, final StreamType type) {
    this.log = log2;
    this.logPrefix = logPrefix;
    this.stream = stream;
    this.type = type;
    
    thread = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          pump();
        } catch (Throwable t) {
          log.error(logPrefix +
              ": Unable to pump output from " + type,
              t);
        }
      }
    }, logPrefix + ": StreamPumper for " + type);
    thread.setDaemon(true);
  }
  
  void join() throws InterruptedException {
    if(started){
    	 thread.join();
    }
   
  }

  void start() {
    if(!started){
    	 thread.start();
    	 started = true;
    };
   
  }

  protected void pump() throws IOException {
    InputStreamReader inputStreamReader = new InputStreamReader(stream);
    BufferedReader br = new BufferedReader(inputStreamReader);
    String line = null;
    while ((line = br.readLine()) != null) {
      if (type == StreamType.STDOUT) {
        log.info(logPrefix + ": " + line);
      } else {
        log.warn(logPrefix + ": " + line);          
      }
    }
  }
}

