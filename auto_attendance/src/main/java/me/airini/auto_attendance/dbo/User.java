package me.airini.auto_attendance.dbo;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 40)
	@NonNull
	private String name;

	@Builder
	public User(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
