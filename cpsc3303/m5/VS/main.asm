; template to start a new project 
; 12/29/2017 Saad Biaz
INCLUDE Irvine32.inc
.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
	char BYTE ?
  sumResult BYTE ?
  
.code
main PROC
  CALL ReadHexByte
  CALL SumFirstN
  MOV sumResult, DL
  
  MOV AL, DH
  CALL WriteHexByte
  MOV AL, sumResult
  CALL WriteHexByte
  
	INVOKE ExitProcess,0
main ENDP

;--------------------------------------------;
; Turns a digit into its ascii equivalent    ;
;                                            ;
; Receives: The digit to convert in AL       ;
; Returns : The ascii code in DL             ;
;--------------------------------------------;
DigitValue2ASCII PROC
  MOV DL, AL
  ADD DL, 30h
  
  CMP AL, 0Ah
  JB endf
    ADD DL, 7h
  endf:

    RET
DigitValue2ASCII ENDP

;--------------------------------------------
; Turns a hex ascii character into a number  
;                                            
; Receives: The hex char in AL               
; Returns : The number in DL                 
;--------------------------------------------
ASCII2DigitValue PROC
  MOV DL, AL
  SUB DL, 30h
  
  CMP AL, 40h
  JB endf
    SUB DL, 7h
  endf:

  RET
ASCII2DigitValue ENDP

;--------------------------------------------
; Writes a hex byte to the console           
;                                            
; Receives: The hex byte in AL               
;--------------------------------------------
WriteHexByte PROC
  MOV char, AL  
  
  ; Write the first digit out
  AND AL, 0F0h
  SHR AL, 4
  CALL DigitValue2ASCII
  MOV AL, DL
  CALL WriteChar
  
  ; Write the second digit out
  MOV AL, char
  AND AL, 0Fh 
  CALL DigitValue2ASCII
  MOV AL, DL
  CALL WriteChar
  
  ; Write the h, carriage return, and line feed out
  MOV EAX, 000D0A68h ; carriage - line feed - 'h'
  MOV CL, 3
  Output:
    CALL WriteChar
    SHR EAX, 8
  LOOP Output  
 
  RET
WriteHexByte ENDP
  
;--------------------------------------------
; Reads a hex byte from the console          
;                                            
; Returns: The hex byte in AL                
;--------------------------------------------
ReadHexByte PROC
  CALL ReadChar
  CALL ASCII2DigitValue
  SHL DL, 4
  MOV char, DL
  
  CALL ReadChar
  CALL ASCII2DigitValue
  ADD DL, char
  
  MOV AL, DL
  RET
ReadHexByte ENDP

;--------------------------------------------
; Sums the integers from 1 through the number 
; provided          
;                                            
; Receives: The number in AL      
; Returns: The sum in DX          
;--------------------------------------------
SumFirstN PROC
  MOV CX, 0
  MOV DX, 0
  
  MOV CL, AL
  Sum:
    ADD DX, CX
  LOOP Sum
  
  RET
SumFirstN ENDP

END main

