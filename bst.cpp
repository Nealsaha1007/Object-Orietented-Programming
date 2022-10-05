#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int main()
{

    vector<int> v;

    v.push_back(1);
    v.push_back(3);
    v.push_back(6);
    v.push_back(7);
    v.push_back(7);


    cout<<"finding 6:- "<<binary_search(v.begin(),v.end(),6)<<endl; 
    cout<<"lower-bound:- "<<lower_bound(v.begin(),v.end(),7)-v.begin()<<endl; 
    cout<<"upper-bound:- "<<upper_bound(v.begin(),v.end(),7)-v.begin()<<endl; 

}