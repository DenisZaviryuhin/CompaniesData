CREATE TABLE IF NOT EXISTS report_details (
    id INT AUTO_INCREMENT PRIMARY KEY,
    financial_data JSON NOT NULL,
    comments VARCHAR(100) NOT NULL,
    report_id INT NOT NULL,
    CONSTRAINT fk_report_details FOREIGN KEY (report_id) REFERENCES report(id) ON DELETE CASCADE

);