package main.java.main.main_ios.objects;

import java.util.List;
	
	
	public class TaskObject {
		public int task;
		public NoteObject note;
		public int status;
		
		 // index location for each report type
		 // formula: initial index (3) + # of options (6) * task (1)
		private static final int initial_index = 3;
		public static final int LAWN_MOW_EDGE = initial_index;
		public static final int LAWN_FERTALIZE = initial_index + 6*1;
		public static final int LAWN_LIME = initial_index + 6*2;
		public static final int LAWN_MOSS_CONTROL = initial_index + 6*3;
		public static final int LAWN_OTHER = initial_index + 6*4;
		public static final int GARDENS_CLEANUP = initial_index + 6*5;
		public static final int TREES_PRUNE = initial_index + 6*6;
		public static final int TREES_FERTALIZE = initial_index + 6*7;
		public static final int TREES_WEED_CONTROL = initial_index + 6*8;
		public static final int TREES_LIME = initial_index + 6*9;
		public static final int SPECIAL_1 = initial_index + 6*10;
		
		// supervisor task options index
		public static final int TASK_NOTE = 0;
		public static final int TASK_MAP = 1;
		public static final int TASK_PHOTO = 2;
		public static final int TASK_INCOMPLETE = 3;
		public static final int TASK_NA = 4;
		public static final int TASK_COMPLETE = 5;
		
		public TaskObject withTask(int task) {
			this.task = task;
			return this;
		}
		
		public TaskObject withNote(NoteObject note) {
			this.note = note;
			return this;
		}
		
		public TaskObject withStatus(int status) {
			this.status = status;
			return this;
		}	
		
		public class NoteObject {
			public List<String> messages;
			
			public NoteObject withNotes(List<String> messages) {
				this.messages = messages;
				return this;
			}
		}
	}