ALTER TABLE fan ADD COLUMN soccer_team_id BIGINT REFERENCES soccer_team;
ALTER TABLE fan ADD CONSTRAINT fk_fan_soccer_team FOREIGN KEY (soccer_team_id) REFERENCES soccer_team(id);