#include<iostream>
#include<array>

using namespace std;

int main(){
    array<int,5>myarray = { 1, 2, 3, 4, 5 };
    int sum=0;
    //int len= sizeof(arr)/sizeof(int);
    for(int i=0; i<myarray.size();i++)
    {
        sum+=myarray[i];
        //cout<<myarray[i]<<"+ ";
    }
    cout<<sum;
}