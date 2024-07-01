package org.example;

import com.dylibso.chicory.runtime.ExportFunction;
import com.dylibso.chicory.runtime.Instance;
import com.dylibso.chicory.runtime.Module;
import com.dylibso.chicory.wasm.types.Value;

public class Main {
	public static void main(String[] args) {
		Module module = Module.builder("SumSquared.wasm").build();
		Instance instance = module.instantiate();

		ExportFunction iterFact = instance.export("SumSquared");
		Value result = iterFact.apply(Value.i32(2), Value.i32(3))[0];
		System.out.println("Result: " + result.asInt()); // should print 25 ((2 + 3) * (2 + 3) = 25)
	}
}