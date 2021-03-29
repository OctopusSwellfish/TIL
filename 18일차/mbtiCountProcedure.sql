DELIMITER $$
CREATE PROCEDURE updateMbti
             (IN inputType varchar(20))
BEGIN
    start transaction;
    update mbti_count set count = count+1 where mbtiType = inputType;
    select sum(count), (select count from mbti_count where mbtiType=inputType) from mbti_count;
    commit;
END $$
DELIMITER ;
