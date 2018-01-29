package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MidToDOT {
	public static void midToDOT(MidComponent mid, String path) throws IOException {
		File f = new File(path);
		FileWriter fw = new FileWriter(f);
		String tempLine = "diagraph graph {";
		fw.write(tempLine);
		tempLine = "size = 5";
		fw.write(tempLine);
		tempLine = "node [shape = point] INIT;";
		fw.write(tempLine);
		tempLine = "node [shape = double circle]";
		for(State s : mid.accStates) {
			tempLine += " S" + s.getId() + " ";
		}
		tempLine += ";";
		fw.write(tempLine);
		tempLine = "node [shape = circle];";
		fw.write(tempLine);
		tempLine = "INIT -> S" + mid.getInit().getId() + ";";
		for(Transition t : mid.transitions) {
			tempLine = "S" + t.getFrom() + " -> " + "S" + t.getTo() + "[label =\"" + t.getLetter() + "\" ];";
			fw.write(tempLine);
		}
		tempLine = "}";
		fw.write(tempLine);
		fw.close();
	}
}
