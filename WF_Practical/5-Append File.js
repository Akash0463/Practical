var fs =require('fs');

function ReadAppend(file,appendFile)
{
    fs.readFile(appendFile,function(err,data)
    {
        if(err) throw err;
        console.log('File was read');

    fs.appendFile(file,data,function(err)
    {
        if(err) throw err;
        console.log('The "data to append" was appended to file!');
    });

    });
}


appendFile = 'first.txt';
file = 'second.txt';
ReadAppend(file,appendFile);

