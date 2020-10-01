; template to start a new project 
; 12/29/2017 Saad Biaz
INCLUDE Irvine32.inc
.386
.model flat,stdcall
.stack 4096
ExitProcess proto,dwExitCode:dword

.data
;General data
  buffer1      BYTE  255  DUP(00h); General use input buffer
  buffer2      BYTE  255  DUP(00h); General use input buffer
  bufferSize1  BYTE ?
  bufferSize2  BYTE ?
  position     BYTE ?

;Exercise1 data
	sentencePrompt  BYTE  "Please enter a sentence: ", 0                                                 
  deleteNumPrompt BYTE  "Please enter the number of characters to delete (in hexadecimal): ", 0        
  deletePosPrompt BYTE  "Please enter the position from where to start deleting(in hexadecimal): ", 0  
  numChars        BYTE ?

;Exercise2 data
  sentencePromptS1 BYTE "Please enter a sentence S_1 to insert: ",0
  sentencePromptS2 BYTE "Please enter a sentence S_2 in which to insert: ",0
  positionPrompt   BYTE "Please enter the position P where to insert: ",0
.code
main PROC
  ;call  Exercise1
  call  WriteCRLF
  call  WriteCRLF
  
  call  Exercise2
  call  WriteCRLF
  call  WriteCRLF
  
	INVOKE ExitProcess,0
main ENDP

; --------------------------------------------
; Result Registers
; --- none
; Parameter Registers
; --- none
; Intermediary Registers
; --- edx: holds string offsets 
; --- ecx: holds size of strings 
; --- eax: receives result from readHex
; --- edi: holds offset of string to delete chars from
; --- ebx: holds number of characters to delete
; --------------------------------------------
Exercise1 PROC
  push edx                           ; 0) Push used registers onto the stack
  push ecx
  push ax
  push edi

  mov   edx,OFFSET sentencePrompt    ; 1) Prompt the user for input
  call  WriteString
  mov   edx,OFFSET buffer1           ; 2) Grab the input
  mov   ecx,SIZEOF buffer1
  call  ReadString
  mov   bufferSize1,al
  
  mov   edx, OFFSET deleteNumPrompt ; 3) Prompt user for number of chars to delete
  call  WriteString
  call  ReadHex                     ; 4) Grab the hex input
  mov   numChars,al
  
  mov   edx, OFFSET deletePosPrompt ; 5) Prompt user for starting position 
  call  WriteString
  call  ReadHex                     ; 6) Grab the hex input
  mov   position,al
  
  mov   edi,OFFSET buffer1          ; 7) Delete ecx characters from a string esi starting from position edx
  mov   bl,numChars
  mov   dl,position
  mov   cl,bufferSize1
  call  DeleteFromString
  
  mov   edx,OFFSET buffer1          ; 8) Write string to output
  call  WriteString
  
  pop   edi
  pop   ax
  pop   ecx
  pop   edx
  ret
Exercise1 ENDP

; --------------------------------------------
; Deletes ECX characters from a string ESI starting from position EDX
;
; Result Registers
; --- none
; Parameter Registers
; --- edi: offset of the string
; --- bl: number of characters to delete
; --- dl: position to delete from 
; --- cl: the length of the string 
; Intermediary Registers
; --- esi: points at the substring just past the characters to be deleted
; --- al:  contains character to move 
; --- ebx: holds the number of characters to delete
; --- edx: holds the position to delete from
; --------------------------------------------
DeleteFromString PROC
  push  edi       ; Save intermediary registers
  push  ax
  push  edx
  push  ebx
  
  and   ebx,0FFh
  and   edx,0FFh
  
  add   edi,edx   ; move the string pointer to the delete position
  mov   esi,edi   ; move pointer to the end of the section that will be deleted
  add   esi,ebx   
  sub   ecx,ebx   ; subtract deleted characters from loop counter
  
  cld             ; Copy string after deleted characters to delete position
  rep   movsb
  
  pop   ebx
  pop   edx
  pop   ax
  pop   edi
  ret
DeleteFromString ENDP

Exercise2 PROC
  push edx                           ; 0) Push used registers onto the stack
  push ecx
  push ax
  push edi
  push ebx

  mov   edx,OFFSET sentencePromptS1  ; 1) Prompt the user for S_1
  call  WriteString
  mov   edx,OFFSET buffer1           ; 2) Grab the input
  mov   ecx,SIZEOF buffer1
  call  ReadString
  mov   bufferSize1,al
  
  mov   edx,OFFSET sentencePromptS2  ; 3) Prompt the user for S_2
  call  WriteString
  mov   edx,OFFSET buffer2           ; 4) Grab the input
  mov   ecx,SIZEOF buffer2
  call  ReadString
  mov   bufferSize2,al
  
  mov   edx, OFFSET positionPrompt   ; 5) Prompt user for starting position 
  call  WriteString
  call  ReadHex                      ; 6) Grab the hex input
  mov   position,al
  
  mov   edi,OFFSET buffer1
  mov   ebx,OFFSET buffer2
  mov   cl,bufferSize1
  mov   al,bufferSize2
  mov   dl,position
  call  InsertString
  
  mov   edx, OFFSET buffer1           ; 8) Write string to output
  call  WriteString

  pop   ebx
  pop   edi
  pop   ax
  pop   ecx
  pop   edx
  ret
Exercise2 ENDP

; --------------------------------------------
; Inserts the string S_1 into string S_2 from position P
;
; Result Registers
; --- none
; Parameter Registers
; --- edi: offset of string S_1
; --- ebx: offset of string S_2
; --- cl: the size of string S_1
; --- al: the size of string S_2
; --- dl: position P
; Intermediary Registers
; --- none
; --------------------------------------------
InsertString PROC
  push  ecx
  push  eax
  push  edx
  
  and   ecx,0FFh
  and   eax,0FFh
  and   edx,0FFh

  dec eax        ; Decrement eax to ignore the null character at the end

  add   edi,ecx  ; Move the S_1 pointer to the end of the string
  mov   esi,edi  ; Put esi at the last character of the string
  add   edi,eax  ; Move the S_1 pointer P past the end of the string
  add   edi,edx

  std           
  rep   movsb    ; Shift the entire string P places to the right
  
  mov   esi,ebx  ; Point esi at string S_2
  add   esi,eax  ; Point esi at the end of string S_2

  mov   ecx,eax  ; loop for length of string S_2
  inc   ecx      ; incrememnt ecx so we don't leave off the first character in the string
  std           
  rep   movsb    ; write the S_2 string backwards
  
  pop   edx
  pop   eax
  pop   ecx
  ret
InsertString ENDP

; --------------------------------------------
; Writes a carriage return and line feed to the console.
;
; Result Registers
; --- none
; Parameter Registers
; --- none
; Intermediary Registers
; --- al:  contains CRLF characters
; --------------------------------------------
WriteCRLF PROC
  push  ax

  mov   al,0Ah
  call  WriteChar
  mov   al,0Dh
  call  WriteChar

  pop   ax
  ret
WriteCRLF ENDP
END main