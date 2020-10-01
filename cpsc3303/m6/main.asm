; template to start a new project
; 12 / 29 / 2017 Saad Biaz
INCLUDE Irvine32.inc
.386
.model flat, stdcall
.stack 4096
ExitProcess proto, dwExitCode:dword

.data
promptStr  BYTE "Please enter a sentence: ", 0; input prompt
promptChar BYTE "Please enter a character: ", 0; input char

buffer1    BYTE  64 DUP(00h); General use input buffer
buffer2    BYTE  64 DUP(00h); General use input buffer
buffer3    BYTE 128 DUP(00h); General use input buffer
byteCount1 DWORD ? ; Holds character count for buffer1
byteCount2 DWORD ? ; Holds character count for buffer2
byteCount3 DWORD ? ; Holds character count for buffer3
charCount  DWORD ?

decStr     BYTE "Decimal length: ", 0
hexStr     BYTE "Hex length: ", 0
occurStr   BYTE "Occurances of char in string: ", 0

firstStr   BYTE "Please enter the first sentence: ", 0
secondStr  BYTE "Please enter the second sentence: ", 0
concatStr  BYTE ?
.code
main PROC
call  Exercise1
call  WriteCRLF
call  WriteCRLF

call  Exercise2
call  WriteCRLF
call  WriteCRLF

call  Exercise3

INVOKE ExitProcess, 0
main ENDP

; --------------------------------------------
;
; --------------------------------------------
Exercise1 PROC
; Prompt the user for input
mov   edx, OFFSET promptStr
call  WriteString

; Grab the input
mov   edx, OFFSET buffer1
mov   ecx, SIZEOF buffer1
call  ReadString
mov   byteCount1, eax
call  WriteCRLF

; Write length of string in decimal
mov   edx, OFFSET decStr
call  WriteString
mov   eax, byteCount1
call  WriteDec
call  WriteCRLF

; Write length of string in hex
mov   edx, OFFSET hexStr
call  WriteString
mov   eax, byteCount1
call  WriteHex
call  WriteCRLF

; Write the string back
mov   edx, OFFSET buffer1
call  WriteString
call  WriteCRLF

ret
Exercise1 ENDP

; --------------------------------------------
;
; --------------------------------------------
Exercise2 PROC
; Prompt the user for string
mov   edx, OFFSET promptStr
call  WriteString

; Grab the input
mov   edx, OFFSET buffer1
mov   ecx, SIZEOF buffer1
call  ReadString
mov   byteCount1, eax

; Prompt the user for char
mov   edx, OFFSET promptChar
call  WriteString

; Grab the char
call  ReadChar

; Count the number of occurances of char in string
mov   esi, OFFSET buffer1
mov   ecx, byteCount1
mov   edx, 00h; counter
Compare :
cmp[esi], al; if esi == al, increment counter
jnz   jump
inc   edx
jump :
inc   esi
loop  compare
EndOfString :

; Write the occurances of char in string
mov   charCount, edx
call  WriteCRLF
mov   edx, OFFSET occurStr
call  WriteString
mov   eax, charCount
call  WriteDec
call  WriteCRLF

ret
Exercise2 ENDP

; --------------------------------------------
;
; --------------------------------------------
Exercise3 PROC
; ======== = Get user input ======== =
; Prompt the user for first sentence
mov   edx, OFFSET firstStr
call  WriteString

; Grab the input
mov   edx, OFFSET buffer1
mov   ecx, SIZEOF buffer1
call  ReadString
mov   byteCount1, eax

; Prompt the user for second sentence
mov   edx, OFFSET secondStr
call  WriteString

; Grab the input
mov   edx, OFFSET buffer2
mov   ecx, SIZEOF buffer2
call  ReadString
mov   byteCount2, eax
call  WriteCRLF

; ======== = Move Strings to buffer 3 ======== =
; Get things ready to copy buff1 to buff3
cld
mov   esi, OFFSET buffer1
mov   edi, OFFSET buffer3
mov   ecx, byteCount1; loop for the length of buff1
rep   movsb; Copy the characters from buffer1 to buffer3

; Get things ready to concat buff2 to buff3
mov   esi, OFFSET buffer2
mov   ecx, byteCount2; loop for the length of buff2
rep   movsb

; Store the length of the new string
mov   edx, edi
sub   edx, OFFSET buffer3
mov   byteCount3, edx

; ======== = Write stuff to console ======== =
; Write concatenated string to console
mov   edx, OFFSET buffer3
call  WriteString
call  WriteCRLF

; Write length of string in decimal
mov   edx, OFFSET decStr
call  WriteString
mov   eax, byteCount3
call  WriteDec
call  WriteCRLF

; Write length of string in hex
mov   edx, OFFSET hexStr
call  WriteString
mov   eax, byteCount3
call  WriteHex
call  WriteCRLF

ret
Exercise3 ENDP

; --------------------------------------------
; Writes a carriage return and line feed to
; the console.
; --------------------------------------------
WriteCRLF PROC
mov   al, 0Ah
call  WriteChar
mov   al, 0Dh
call  WriteChar

ret
WriteCRLF ENDP

END main