function varargout = jstgui(varargin)
% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @jstgui_OpeningFcn, ...
                   'gui_OutputFcn',  @jstgui_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end
if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT EDIT

function jstgui_OpeningFcn(hObject, eventdata, handles, varargin)
handles.output = hObject;
guidata(hObject, handles);

function varargout = jstgui_OutputFcn(hObject, eventdata, handles) 

varargout{1} = handles.output;

%-----------------di atas kodingan punya matlab gg usah diubah------------%
%---------------------sourcode aplikasi ada dibawah-----------------------%
%-----------------------------<<<<<>>>>>----------------------------------%

function kalkulasi_Callback(hObject, eventdata, handles)%tombol save
bermain = str2num(get(handles.bermain,'String'));
tidur   = str2num(get(handles.tidur,'String'));
belajar = str2num(get(handles.belajar,'String'));
lain    = str2num(get(handles.lain,'String'));
lain1   = 24-(bermain+tidur+belajar);
total   = bermain+tidur+belajar;
lain2   = total+lain;
bermain2= isempty(bermain);
tidur2  = isempty(tidur);
belajar2 = isempty(belajar); 
disp (total);%dihapus gg masalah
disp (lain1);%--------###-------%
set(handles.lain,'String',lain1);
data  = [bermain
        tidur
        belajar];
limit = 24;
if total > limit ;
    msgbox('Jumlah jam aktivitas melebihi 24 Jam', 'Error','error');
elseif bermain2 == 1;
    msgbox('Isi form bermain', 'Error','error');
elseif tidur2 == 1;
    msgbox('Isi form tidur', 'Error','error');
elseif belajar2 == 1;
    msgbox('Isi form belajar', 'Error','error');
elseif lain2 > limit;
    msgbox('Jumlah waktu aktivitas melebihi 24 Jam', 'Error','error');
else
    msgbox('oke data sudah disimpan','Sukses');
    save('datann1','data');
end

function pushbutton2_Callback(hObject, eventdata, handles)% tombol reset
 set(handles.bermain,'string','default');
 set(handles.tidur,'string','default');
 set(handles.lain,'String','default');
 set(handles.belajar,'string','default');
 set(handles.hasil,'string','default');
 set(handles.saran,'string','default');

function prediksi_Callback(hObject, eventdata, handles)% tombol prediksi
load('datann1','data');
load('jstin','jstbelajar');
hasil = sim (jstbelajar,data);
hasil2 = fix(hasil);
set(handles.hasil,'String',hasil2); 
if hasil2 > 70;
    set(handles.saran,'String','oke,nilai anda baik');
else
    set(handles.saran,'String','nilai anda buruk, perbanyak istighfar dan belajar atau kurangi aktivitas bermain serta tidur anda'); 
end

%----------------------------------###------------------------------------%
%--------------------------jangan diisi dulu------------------------------%
function load_Callback(hObject, eventdata, handles)% tombol load
function train_Callback(hObject, eventdata, handles)% tombol train