package musicmachine;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BeatBox {

	private static final int NUM_INSTRUMENTS = 16;
	private static final int NUM_TICKS = 16;
	private JPanel mainPanel;
	private ArrayList<JCheckBox> checkboxList;
	private JSpinner spinner;
	private Sequencer sequencer;
	private Sequence sequence;
	private Track track;
	private JFrame theFrame;
	private final JFileChooser fc = new JFileChooser();
	private int currentFileIndex = 1;
	private File currentFile = null;
	private JTextArea fileTextArea;

	private static final String[] instrumentNames = { "Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal",
			"Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga", "Cowbell", "Vibraslap",
			"Low-mid Tom", "High Agogo", "Open Hi Conga" };
	private static final int[] instruments = { 35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63 };

	public static void main(String[] args) {
		new BeatBox().buildGUI();
	}

	private void buildTrackAndStart() {
		int[] trackList = null;
		sequence.deleteTrack(track);
		track = sequence.createTrack();
		for (int i = 0; i < NUM_INSTRUMENTS; ++i) {
			trackList = new int[NUM_TICKS];
			int key = instruments[i];
			for (int j = 0; j < NUM_TICKS; ++j) {
				JCheckBox jc = (JCheckBox) (checkboxList.get(j + (NUM_TICKS * i)));
				if (jc.isSelected()) {
					trackList[j] = key;
				} else {
					trackList[j] = 0;
				}
			}
			makeTracks(trackList);
			track.add(makeEvent(ShortMessage.CONTROL_CHANGE, 1, 127, 0, NUM_TICKS));
		}
		track.add(makeEvent(ShortMessage.PROGRAM_CHANGE, 9, 1, 0, NUM_TICKS - 1));
		try {
			sequencer.setSequence(sequence);
			sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			sequencer.start();
			sequencer.setTempoInBPM(120);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return event;
	}

	private void makeTracks(int[] list) {
		for (int i = 0; i < NUM_TICKS; ++i) {
			int key = list[i];
			if (key != 0) {
				track.add(makeEvent(ShortMessage.NOTE_ON, 9, key, 100, i));
				track.add(makeEvent(ShortMessage.NOTE_OFF, 9, key, 100, i + 1));
			}
		}

	}

	private void buildGUI() {
		setUpMidi();
		
		theFrame = new JFrame("Cyber BeatBox");
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		checkboxList = new ArrayList<JCheckBox>();
		Box buttonBox = new Box(BoxLayout.Y_AXIS);

		JPanel tempoPanel = new JPanel();	
		
		JLabel tempoLabel = new JLabel("Tempo");
		tempoPanel.add(tempoLabel);
		
		SpinnerNumberModel tempoSpinnerModel = new SpinnerNumberModel(sequencer.getTempoFactor(), 0.1, 100, 0.1);
		spinner = new JSpinner(tempoSpinnerModel);
		spinner.addChangeListener(new MySpinnerListener());
		tempoPanel.add(spinner);	
		
		generateDefaultFilename();
		
		buttonBox.add(tempoPanel);
		
		JButton start = new JButton("Start");
		start.addActionListener(new MyStartListener());
		buttonBox.add(start);

		JButton stop = new JButton("Stop");
		stop.addActionListener(new MyStopListener());
		buttonBox.add(stop);

		JButton upTempo = new JButton("Tempo Up");
		upTempo.addActionListener(new MyUpTempoListener());
		buttonBox.add(upTempo);

		JButton downTempo = new JButton("Tempo Down");
		downTempo.addActionListener(new MyDownTempoListener());
		buttonBox.add(downTempo);

		//
		
		JPanel filePanel = new JPanel();
		
		JLabel fileLabel = new JLabel("File");
		filePanel.add(fileLabel);
		fileTextArea = new JTextArea(currentFile.getPath());
		filePanel.add(fileTextArea);
		
		buttonBox.add(filePanel);
		
		JButton changeFile = new JButton("Select file");
		changeFile.addActionListener(new MyFileListener());
		buttonBox.add(changeFile);
		JButton savePattern = new JButton("Save");
		savePattern.addActionListener(new MySendListener());
		buttonBox.add(savePattern);
		JButton loadFile = new JButton("Load");
		loadFile.addActionListener(new MyReadInListener());
		buttonBox.add(loadFile);
		
		//
		
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for (int i = 0; i < NUM_INSTRUMENTS; i++) {
			nameBox.add(new Label(instrumentNames[i]));
		}

		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.WEST, nameBox);

		GridLayout grid = new GridLayout(NUM_INSTRUMENTS, NUM_TICKS);
		grid.setVgap(1);
		grid.setHgap(2);
		mainPanel = new JPanel(grid);
		background.add(BorderLayout.CENTER, mainPanel);

		for (int i = 0; i < NUM_INSTRUMENTS*NUM_TICKS; ++i) {
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkboxList.add(c);
			mainPanel.add(c);
		}
		
		theFrame.getContentPane().add(background);

		theFrame.setBounds(50, 50, 300, 300);
		theFrame.pack();
		theFrame.setVisible(true);

	}

	private void generateDefaultFilename() {
		currentFile = new File("beatbox" + Integer.toString(currentFileIndex) + ".ser");
		currentFileIndex++;
	}
	
	private void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(120);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class MyDownTempoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float) (tempoFactor * .97));
			spinner.getModel().setValue(Double.valueOf((double) sequencer.getTempoFactor()));
		}

	}

	private class MyUpTempoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			float tempoFactor = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float) (tempoFactor * 1.03));
			spinner.getModel().setValue(Double.valueOf((double) sequencer.getTempoFactor()));
		}

	}

	private class MyStopListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			sequencer.stop();
		}

	}

	private class MyStartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			buildTrackAndStart();

		}

	}

	private class MySpinnerListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent event) {
			sequencer.setTempoFactor((float) ((Double) spinner.getValue()).doubleValue()); 
			
		}
		
	}
	
	private class MySendListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent event) {
			boolean[] checkboxState = new boolean[NUM_INSTRUMENTS*NUM_TICKS];
			
			for(int i = 0; i < NUM_INSTRUMENTS*NUM_TICKS; ++i) {
				JCheckBox check = (JCheckBox) checkboxList.get(i);
				if(check.isSelected()) {
					checkboxState[i] = true;
				}
			}
			
			ObjectOutputStream os = null;
			try {
				FileOutputStream fileOut = new FileOutputStream(currentFile);
				os = new ObjectOutputStream(fileOut);
				os.writeObject(checkboxState);
				generateDefaultFilename();
				fileTextArea.setText(currentFile.getName());
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				try {
					if(os != null) os.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		
	}
	
	private class MyReadInListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			boolean[] checkboxState = null;
			File toReadFile = null;
			ObjectInputStream is = null;
			FileFilter filter = new FileNameExtensionFilter("SER file", "ser");
			fc.addChoosableFileFilter(filter);
			int returnVal = fc.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				toReadFile = fc.getSelectedFile();
				try {
					FileInputStream fileIn = new FileInputStream(toReadFile);
					is = new ObjectInputStream(fileIn);
					checkboxState = (boolean[]) is.readObject();
				} catch (IOException | ClassNotFoundException ex) {
					ex.printStackTrace();
				} finally {
					try {
						if(is != null) is.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
				for(int i = 0; i < NUM_INSTRUMENTS*NUM_TICKS; ++i) {
					JCheckBox check = (JCheckBox) checkboxList.get(i);
					if(checkboxState[i]) {
						check.setSelected(true);
					} else {
						check.setSelected(false);
					}
					sequencer.stop();
					buildTrackAndStart();
				}
			}
		}
		
	}
	
	private class MyFileListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			int returnVal = fc.showSaveDialog(null);		
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fc.getSelectedFile();
				if(checkFileExtension(selectedFile)) {
					currentFile = selectedFile;
					fileTextArea.setText(currentFile.getName());
				}
			}
		}
		
	}
	
	private static boolean checkFileExtension(File file) {
		String fileName = file.getName();
		int i = fileName.lastIndexOf('.');
		if(i > 0) {
			return fileName.substring(i).equals(".ser");
		} else {
			return false;
		}
	}
	
}
