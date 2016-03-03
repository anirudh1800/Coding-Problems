// Brute force funct
function maxCellsInRegion(i, j, max_rows, max_cols, matrix, visited){
    var count = 0;
    
    if(i < 0 || i >= max_rows)
        return 0;
    
    if(j < 0 || j >= max_cols)
        return 0;
    
   if(matrix[i][j] == 1 && !visited[i][j]){
        count = 1;
        visited[i][j] = true; 
        
        count += maxCellsInRegion(i+1, j, max_rows, max_cols, matrix, visited);
        count += maxCellsInRegion(i, j+1, max_rows, max_cols, matrix, visited);
        count += maxCellsInRegion(i+1, j+1, max_rows, max_cols, matrix, visited);
        count += maxCellsInRegion(i-1, j, max_rows, max_cols, matrix, visited);
        count += maxCellsInRegion(i, j-1, max_rows, max_cols, matrix, visited);
        count += maxCellsInRegion(i+1, j-1, max_rows, max_cols, matrix, visited);
        count += maxCellsInRegion(i-1, j-1, max_rows, max_cols, matrix, visited);
        count += maxCellsInRegion(i-1, j+1, max_rows, max_cols, matrix, visited);   
    }
    
    return count;
}

function processData(input) {
    var lines = input.split('\n');
    var rows = parseInt(lines[0]);
    var cols = parseInt(lines[1]);
    
    var matrix = Array(rows);
    var visited = Array(rows);
    
    var i,j;
    
    // Input processing
    for(i = 0; i < rows; i++){
        matrix[i] = new Array(cols);
        visited[i] = new Array(cols);
    }
        
    for(i = 2; i < lines.length; i++){
        var row_vals = lines[i].split(' ');
        for(j = 0; j < cols; j++) {
            matrix[i - 2][j] = parseInt(row_vals[j]);
            visited[i-2][j] = false;
        }
    }
    
    // Brute force approach
    var counts = Array();
    for(i = 0; i < rows; i++){
        for(j = 0; j < cols; j++){
            counts.push(maxCellsInRegion(i, j, rows, cols, matrix, visited));
        }
    }
    
    var result = 0;
    for(i of counts){
        if(result < i)
            result = i;
    }
     
    console.log(result);    
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

