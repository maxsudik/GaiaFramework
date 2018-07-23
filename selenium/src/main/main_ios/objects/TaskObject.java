package main.main_ios.objects;

import java.util.List;
	
	
	public class TaskObject {
		public int task;
		public NoteObject note;
		public int status;
		
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