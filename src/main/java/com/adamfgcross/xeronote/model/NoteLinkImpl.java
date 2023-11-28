package com.adamfgcross.xeronote.model;

import jakarta.persistence.*;

@Entity
public class NoteLinkImpl implements NoteLink<NoteImpl> {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	 @ManyToOne
	 @JoinColumn(name="origin_note_id")
	private NoteImpl originNote;
	
	@ManyToOne
    @JoinColumn(name = "target_note_id")
	private NoteImpl targetNote;
	
	private String comment;
	
	public NoteLinkImpl(NoteImpl originNote, NoteImpl targetNote) {
		this.originNote = originNote;
		this.targetNote = targetNote;
	}
	
	public NoteLinkImpl(NoteImpl originNote, NoteImpl targetNote, String comment) {
		this.originNote = originNote;
		this.targetNote = targetNote;
		this.comment = comment;
	}
	
	public NoteImpl getOriginNote() {
		return originNote;
	}
	
	public void setOriginNote(NoteImpl originNote) {
		this.originNote = originNote;
	}
	
	public NoteImpl getTargetNote() {
		return targetNote;
	}
	public void setTargetNote(NoteImpl targetNote) {
		this.targetNote = targetNote;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getComment() {
		return comment;
	}
}
