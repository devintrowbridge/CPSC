; template to start a new project 
; 12/29/2017 Saad Biaz
INCLUDE Irvine32.inc
.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
	char BYTE ?

.code
main proc
  ; PROGRAMMING EXERCISE 1
    MOV AL, 6   ; Define a test value
  
    OR AL, 30h
    MOV DL, AL
    CALL WriteChar

    ; Write a CRLF so we can be a new line for the next exercise
    MOV AL, 0Ah
    CALL WriteChar

    MOV AL, 0Dh
    CALL WriteChar

  ; PROGRAMMING EXERCISE 2
    MOV AL, 88h   ; Define a test value

    ; Store digits of AL in DH and DL
    MOV DH, AL
    SHR DH, 4
    OR DH, 30h

    MOV DL, AL
    AND DL, 0Fh
    OR DL, 30h

    ; Write DX to output
    MOV AL, DH
    CALL WriteChar

    MOV AL, DL
    CALL WriteChar

    MOV AL, 'h'
    CALL WriteChar

    ; Write a CRLF so we can be a new line for the next exercise
    MOV AL, 0Ah
    CALL WriteChar

    MOV AL, 0Dh
    CALL WriteChar

  ; PROGRAMMING EXERCISE 3
    CALL ReadChar
    MOV DL, AL
    AND DL, 0Fh


  ; PROGRAMMING EXERCISE 4
    CALL ReadChar
    MOV DL, AL  ; Store the ASCII number in DL
    SHL DL, 4   ; Convert to decimal digit and move to MSN

    CALL ReadChar
    AND AL, 0Fh ; Mask the LSN
    OR AL, DL   ; Bring the MSN in

	invoke ExitProcess,0
main endp
end main