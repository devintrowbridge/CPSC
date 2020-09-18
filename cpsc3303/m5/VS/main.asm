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
  hexDigits BYTE ?
.code
main PROC
  CALL ReadHexByte
  CALL SumFirstN
  MOV sumResult, DL
  
  MOV AL, DH
  CALL WriteTwoHexDigits
  MOV AL, sumResult
  CALL WriteHexByte
  
	INVOKE ExitProcess,0
main ENDP

;--------------------------------------------
; Gets the ascii code for a hex digit
;                                            
; Receives: The digit to convert in AL       
; Returns : The ascii code in DL             
;--------------------------------------------
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
; Takes the ascii code for a hex digit and 
; returns the hex digit in DL 
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
; Writes the hex digits in AL to the
; console, followed by an 'h' and CRLF           
;                                            
; Receives: The hex byte in AL               
;--------------------------------------------
WriteHexByte PROC
  CALL WriteTwoHexDigits
  CALL WriteHexTail 
 
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
  CMP AL, 00h
  JZ skip
    sum:
      ADD DX, CX
    LOOP sum
  skip:
  
  RET
SumFirstN ENDP

;--------------------------------------------
; Writes the character 'h', a carriage return
; and line feed to the console          
;--------------------------------------------
WriteHexTail PROC
  MOV AL, 68h
  CALL WriteChar
  MOV AL, 0Ah
  CALL WriteChar
  MOV AL, 0Dh
  CALL WriteChar
  
  RET
WriteHexTail ENDP

;--------------------------------------------
; Writes the hex digits in AL to the console        
;                                            
; Receives: The digits in AL          
;--------------------------------------------
WriteTwoHexDigits PROC
  MOV hexDigits, AL  
  
  ; Write the first digit out
  SHR AL, 4
  CALL DigitValue2ASCII
  MOV AL, DL
  CALL WriteChar
  
  ; Write the second digit out
  MOV AL, hexDigits
  AND AL, 0Fh 
  CALL DigitValue2ASCII
  MOV AL, DL
  CALL WriteChar
  
  RET
WriteTwoHexDigits ENDP

END main

