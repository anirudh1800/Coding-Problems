List.makeNode = function() {
    return { data: null, next: null};
}

function processData(input) {
   let lines = input.split("\n");
   let cur_line = 0;
   let n = lines[cur_line++].parseInt();

   for(let i = 0; i < n; i++) {
       let start_x, start_y, end_x, end_y;
       let array_lens = line[cur_line++].split("").map(Number);

       // Array Creation
       let matrix = new Array(array_lens[0]);
       for(let k = 0; k < matrix.length; k++)
           matrix[k] = new Array(array_lens[1]);

       // Array Initialization
       for(let m = 0; m < matrix.length; m++){
           let line = line[cur_line++].split(" ");
           for(let n = 0; n < matrix[0].length; n++){
               matrix[m][n] = line[n];
               if(matrix[m][n] == '*'){
                   end_x = m;
                   end_y = n;
               } else if(matrix[m][n] == 'M'){
                   start_x = m;
                   start_y = n;
               }
           }
       }

       console.log(wavesToDest(matrix, m, n, start_x, start_y, end_x, end_y));
   }

}

function wavesToDest(matrix, m, n, start_x, start_y, end_x, end_y){
    matrix


}

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
   processData(_input);
});

