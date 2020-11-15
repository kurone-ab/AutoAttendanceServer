package me.airini.auto_attendance.dbo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "io_log")
@Getter
@Setter
@NoArgsConstructor
public class IOLog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "datetime")
	private LocalDateTime date;//1day = 86400s
	@ManyToOne
	private User user;
	@ManyToOne
	private Place place;

	@Builder
	public IOLog(LocalDateTime date, User user, Place place) {
		this.date = date;
		this.user = user;
		this.place = place;
	}

	@Override
	public String toString() {
		return "IOLog{" +
				"id=" + id +
				", date=" + date +
				", user=" + user +
				", place=" + place +
				'}';
	}
}
