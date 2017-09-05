/*=============================================================================
Author-Vaishali Jain
Description: -Select command to display info of all the books issued ,issue_date,
              accession_no,member_id,return_date
             -display results in ascending order of issue date and within issue 
              date in ascending order of member's name.
===============================================================================*/
SELECT E.issue_date,E.accession_no,E.member_id,F.return_date
FROM book_issue as E
LEFT JOIN book_return as F
ON E.accession_no=F.accession_no AND E.member_id=F.member_id 
LEFT JOIN members as M
ON E.member_id=M.member_id
ORDER BY E.issue_date ASC,M.member_name ASC;


