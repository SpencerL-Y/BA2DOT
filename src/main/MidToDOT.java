package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MidToDOT {
	public static void midToDOT(MidComponent mid, String path) throws IOException {
		File f = new File(path);
		FileWriter fw = new FileWriter(f);
		String tempLine = "digraph result {\n";
		fw.write(tempLine);
		tempLine = "size = \"2\";\n";
		fw.write(tempLine);
		tempLine = "node [shape = point] INIT;\n";
		fw.write(tempLine);
		tempLine = "node [shape = doublecircle]";
		for(State s : mid.accStates) {
			tempLine += " S" + s.getId() + " ";
		}
		tempLine += ";\n";
		fw.write(tempLine);
		tempLine = "node [shape = circle];\n";
		fw.write(tempLine);
		tempLine = "INIT -> S" + mid.getInit().getId() + ";\n";
		fw.write(tempLine);
		for(Transition t : mid.transitions) {
			tempLine = "S" + t.getFrom() + " -> " + "S" + t.getTo() + "[label =\"" + t.getLetter() + "\" ];\n";
			fw.write(tempLine);
		}
		tempLine = "}\n";
		fw.write(tempLine);
		fw.close();
	}
}
