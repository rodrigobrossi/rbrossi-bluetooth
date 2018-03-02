package br.com.bruno.kernel;

import java.util.HashMap;

import br.com.bruno.command.AbstractCommand;


public class Kernel {
	private final static Kernel k = new Kernel();
	private static HashMap map = new HashMap();
	
	static{
		map.put(IKernel.S_CODE,new Integer(IKernel.CODE));
		
	}
	private Kernel(){
		
		
	}
	
	public static Kernel getInstance(){
		return k;
	}
	
	public synchronized AbstractCommand getCommand(String command){
		int commandCode = Kernel.getCommandCode(command);
		switch(commandCode){
			case IKernel.CODE: return null; 
		
		}
		return null;
	}

	private static int getCommandCode(String command) {
		return ((Integer)map.get(command)).intValue();
	} 

}
