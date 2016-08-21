var Node = function(x, y){
    this.x = x;
    this.y = y;
}

Node.prototype.printNode = function(){
    console.log(this.x + "," + this.y);
}

function wavesToDest(matrix, i, j, end_x, end_y, visited, path) {
    if(i < 0 || i >= matrix.length)
        return false;

    if(j < 0 || j >= matrix[0].length)
        return false;

    if(matrix[i][j] == 'X')
        return false;

    if(i == end_x && j == end_y)
        return true;

    if((matrix[i][j] == '.' || matrix[i][j] == 'M') && !visited[i][j]) {
        visited[i][j] = true;

        if(wavesToDest(matrix, i, j+1, end_x, end_y, visited, path)){
              path.push(new Node(i,j+1));
              return true;
        }

        if(wavesToDest(matrix, i-1, j, end_x, end_y, visited, path)){
              path.push(new Node(i-1, j));
              return true;
        }

        if(wavesToDest(matrix, i+1, j, end_x, end_y, visited, path)){
              path.push(new Node(i+1, j));
              return true;
        }

        if(wavesToDest(matrix, i, j-1, end_x, end_y, visited, path)){
              path.push(new Node(i, j-1));
              return true;
        }
    }

    return false;
}

function genWaves(path, matrix) {
  let direc = 0;

  let node = path.pop();

  if(checkDirections(node.x, node.y, matrix) >= 2){
    direc = 1;
  }

  while(path.length > 1 && (node = path.pop()) != undefined){
    if(checkDirections(node.x, node.y, matrix) > 2){
      direc++;
    }
  }

  return direc;
}

function checkDirections(x, y, matrix) {
  let count = 0;

  if(y > 0 && (matrix[x][y-1] == '.' || matrix[x][y-1] == 'M' || matrix[x][y-1] == '*'))
    count++;

  if((y < matrix[0].length - 1) && (matrix[x][y+1] == '.' || matrix[x][y+1] == 'M' || matrix[x][y+1] == '*'))
    count++;

  if((x < matrix.length - 1) && (matrix[x+1][y] == '.' || matrix[x+1][y] == 'M' || matrix[x+1][y] == '*'))
    count++;

  if(x > 0 && (matrix[x-1][y] == '.' || matrix[x-1][y] == 'M' || matrix[x-1][y] == '*'))
    count++;

  return count;
}

function processData(input) {
   let lines = input.split("\n");
   let cur_line = 0;
   let t = parseInt(lines[cur_line++]);

   for(let i = 0; i < t; i++) {
       let start_x, start_y, end_x, end_y;
       let array_lens = lines[cur_line++].split(" ").map(Number);

       // Array Creation
       let matrix = new Array(array_lens[0]);
       let visited = new Array(array_lens[0]);
       for(let k = 0; k < matrix.length; k++){
        matrix[k] = new Array(array_lens[1]);
        visited[k] = new Array(array_lens[1]);
       }

       // Array Initialization
       for(let m = 0; m < matrix.length; m++){
           let line = lines[cur_line++].split("");
           for(let n = 0; n < matrix[0].length; n++){
               matrix[m][n] = line[n];
               visited[m][n] = false;
               if(matrix[m][n] == '*'){
                   end_x = m;
                   end_y = n;
               } else if(matrix[m][n] == 'M'){
                   start_x = m;
                   start_y = n;
               }
           }
       }

       let wave = parseInt(lines[cur_line++]);
       let path = new Array();
       wavesToDest(matrix, start_x, start_y, end_x, end_y, visited, path);
       path.push(new Node(start_x, start_y));

       if(wave == genWaves(path, matrix)){
         console.log("Impressed");
       } else{
         console.log("Oops!");
       }
   }

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
