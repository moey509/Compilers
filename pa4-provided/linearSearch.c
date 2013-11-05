#include <stdio.h>

// Returns the index in the array where the string appears. 
// Returns -1 if the string does not appear in the array
int __indexof(char** functionNameArray, char* functionName, int arrayLength){
	for (int i = 0; i<arrayLength; i++){
		int eof = 1;
		int counter = 0;
		char* str = functionNameArray[i];
		//printf("%s\n", str);
		char c1 = str[0];
		char c2 = functionName[0];
		while (eof){
			//printf("Counter: %i\n", counter);
			if (c1 != c2){
				//printf("c1 = %c\n", c1);
				//printf("c2 = %c\n", c2);
				eof = 0;
			}
			else {
				if (c1 == '\0')
					return i;
				else {
					counter++;
					c1 = str[counter];
					c2 = functionName[counter];
				}	
			}
		}
	}
	return -1;
}

int main(){
	char* array[5];
	array[0] = "Hello\0";
	array[1] = "World\0";
	array[2] = "Mello\0";
	array[3] = "Jello\0";
	array[4] = "Mellon\0";
	char** array_t = array;
	int output = __indexof(array_t, "Jello\0", 5);
	printf("%d\n", output);
	output = __indexof(array_t, "Hello\0",5);
	printf("%d\n", output);
	output = __indexof(array_t, "Hi\0",5);
	printf("%d\n", output);
	return 0;
}