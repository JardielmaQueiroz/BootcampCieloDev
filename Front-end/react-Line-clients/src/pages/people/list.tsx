/* eslint-disable jsx-a11y/anchor-is-valid */
import {
  Breadcrumb,
  Button,
  Checkbox,
  Label,
  Modal,
  Table,
  TextInput,
  Select
} from "flowbite-react";
import type { FC } from "react";
import { useState } from "react";

import {
  HiChevronLeft,
  HiChevronRight,
  HiCog,
  HiDocumentDownload,
  HiDotsVertical,
  HiExclamationCircle,
  HiHome,
  HiOutlineExclamationCircle,
  HiOutlinePencilAlt,
  HiPlus,
  HiTrash,
} from "react-icons/hi";
import NavbarSidebarLayout from "../../layouts/navbar-sidebar";

const UserListPage: FC = function () {
  return (
    <NavbarSidebarLayout isFooter={false}>
      <div className="block items-center justify-between border-b border-gray-200 bg-white p-4 dark:border-gray-700 dark:bg-gray-800 sm:flex">
        <div className="mb-1 w-full">

          <div className="mb-4">

            <Breadcrumb className="mb-4">
              <Breadcrumb.Item href="#">
                <div className="flex items-center gap-x-3">
                  <HiHome className="text-xl" />
                  <span className="dark:text-white">Home</span>
                </div>
              </Breadcrumb.Item>

            </Breadcrumb>

            <h1 className="text-xl font-semibold text-gray-900 dark:text-white sm:text-2xl">
              Lista de Clientes
            </h1>

          </div>

          <div className="sm:flex">
            <div className="mb-3 hidden items-center dark:divide-gray-700 sm:mb-0 sm:flex sm:divide-x sm:divide-gray-100">
              
              <form className="lg:pr-3">
                <Label htmlFor="people-search" className="sr-only">
                  Pesquisar
                </Label>
                <div className="relative mt-1 lg:w-64 xl:w-96">
                  <TextInput
                    id="people-search"
                    name="people-search"
                    placeholder="Pesquisar Clientes"
                    type="text"
                  />
                </div>
              </form>

            </div>
            <div className="ml-auto flex items-center space-x-2 sm:space-x-3">
              <AddUserModal />
            </div>
          </div>
        </div>
      </div>
      <div className="flex flex-col">
        <div className="overflow-x-auto">
          <div className="inline-block min-w-full align-middle">
            <div className="overflow-hidden shadow">
              <AllpeopleTable />
            </div>
          </div>
        </div>
      </div>
      <Pagination />
    </NavbarSidebarLayout>
  );
};

const AddUserModal: FC = function () {
  const [isOpen, setOpen] = useState(false);

  return (
    <>
      <Button color="primary" onClick={() => setOpen(true)}>
        <div className="flex items-center gap-x-3">
          <HiPlus className="text-xl" />
          Adicionar
        </div>
      </Button>
      <Modal onClose={() => setOpen(false)} show={isOpen}>
        <Modal.Header className="border-b border-gray-200 !p-6 dark:border-gray-700">
          <strong>Adicionar Cliente</strong>
        </Modal.Header>
        <Modal.Body>
          <div className="grid grid-cols-1 gap-6 sm:grid-cols-2">

            <div>
              <Label htmlFor="department">Tipo</Label>
              <div className="mt-1">
                <Select id="people" required>
                  <Label htmlFor="people-search" className="sr-only">
                      Pesquisar
                    </Label>
                    <option>
                      Pessoa Física
                    </option>
                    <option>
                      Pessoa Jurídica        
                    </option>
                </Select>
              </div>
            </div>

            <div>
              <Label htmlFor="name">Name</Label>
              <div className="mt-1">
                <TextInput
                  id="name"
                  name="name"
                  placeholder="Jardielma"
                  required
                  type="text"
                />
              </div>
            </div>

            <div>
              <Label htmlFor="mcc">MCC</Label>
              <div className="mt-1">
                <TextInput
                  id="mcc"
                  name="mcc"
                  placeholder="0014"
                  type="number"
                  required
                />
              </div>
            </div>

            <div>
              <Label htmlFor="CPF/CNPJ">CPF/CNPJ</Label>
              <div className="mt-1">
                <TextInput
                  id="cadastro_pessoa"
                  name="cadastro_pessoa"
                  placeholder="173.215.490-20"
                  type="number"
                  required
                />
              </div>
            </div>

            <div>
              <Label htmlFor="email">Email</Label>
              <div className="mt-1">
                <TextInput
                  id="email"
                  name="email"
                  placeholder="example@company.com"
                  type="email"
                  required
                />
              </div>
            </div>
            <div>
              <Label htmlFor="phone">Telefone</Label>
              <div className="mt-1">
                <TextInput
                  id="phone"
                  name="phone"
                  placeholder="(99) 9 9999-9999"
                  type="tel"
                  required
                />
              </div>
            </div>

          </div>
          <div className="my-5">
              <Label htmlFor="razao_social">Razão Social</Label>
              <div className="mt-1">
                <TextInput
                  id="razao_social"
                  name="razao_social"
                  placeholder="Razão Social"
                  sizing="lg"
                  type="text"
                />
              </div>
            </div>
        </Modal.Body>
        <Modal.Footer>
          <Button color="primary" onClick={() => setOpen(false)}>
            Adicionar
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
};

const AllpeopleTable: FC = function () {
  return (
    <Table className="min-w-full divide-y divide-gray-200 dark:divide-gray-600">
      <Table.Head className="bg-gray-100 dark:bg-gray-700">
        <Table.HeadCell>
          <Label htmlFor="select-all" className="sr-only">
            Select all
          </Label>
          <Checkbox id="select-all" name="select-all" />
        </Table.HeadCell>
        <Table.HeadCell>Nome</Table.HeadCell>
        <Table.HeadCell>E-mail</Table.HeadCell>
        <Table.HeadCell>CPF/CNPJ</Table.HeadCell>
        <Table.HeadCell>Tipo</Table.HeadCell>
        <Table.HeadCell>Ação</Table.HeadCell>
      </Table.Head>
      <Table.Body className="divide-y divide-gray-200 bg-white dark:divide-gray-700 dark:bg-gray-800">
        <Table.Row className="hover:bg-gray-100 dark:hover:bg-gray-700">
          <Table.Cell className="w-4 p-4">
            <div className="flex items-center">
              <Checkbox aria-describedby="checkbox-1" id="checkbox-1" />
              <label htmlFor="checkbox-1" className="sr-only">
                checkbox
              </label>
            </div>
          </Table.Cell>
          <Table.Cell className="mr-12 flex items-center space-x-6 whitespace-nowrap p-4 lg:mr-0">
            <div className="text-sm font-normal text-gray-500 dark:text-gray-400">
              <div className="text-base font-semibold text-gray-900 dark:text-white">
                Neil Sims
              </div>
            </div>
          </Table.Cell>
          <Table.Cell className="whitespace-nowrap p-4 text-base font-medium text-gray-900 dark:text-white">
            teste@teste.com	
          </Table.Cell>
          <Table.Cell className="whitespace-nowrap p-4 text-base font-medium text-gray-900 dark:text-white">
            80.095.721/0001-61
          </Table.Cell>
          <Table.Cell className="whitespace-nowrap p-4 text-base font-normal text-gray-900 dark:text-white">
            <div className="flex items-center">
                Pessoa Jurídica
            </div>
          </Table.Cell>
          <Table.Cell>
            <div className="flex items-center gap-x-3 whitespace-nowrap">
              <EditUserModal />
              <DeleteUserModal />
            </div>
          </Table.Cell>
        </Table.Row>
        <Table.Row className="hover:bg-gray-100 dark:hover:bg-gray-700">
          <Table.Cell className="w-4 p-4">
            <div className="flex items-center">
              <input
                id="checkbox-2"
                aria-describedby="checkbox-1"
                type="checkbox"
                className="h-4 w-4 rounded border-gray-300 bg-gray-50 focus:ring-4 focus:ring-primary-300 dark:border-gray-600 dark:bg-gray-700 dark:ring-offset-gray-800 dark:focus:ring-primary-600"
              />
              <label htmlFor="checkbox-2" className="sr-only">
                checkbox
              </label>
            </div>
          </Table.Cell>
          <Table.Cell className="mr-12 flex items-center space-x-6 whitespace-nowrap p-4 lg:mr-0">
            <div className="text-sm font-normal text-gray-500 dark:text-gray-400">
              <div className="text-base font-semibold text-gray-900 dark:text-white">
                Roberta Casas
              </div>
            </div>
          </Table.Cell>
          <Table.Cell className="whitespace-nowrap p-4 text-base font-medium text-gray-900 dark:text-white">
            teste@teste.com	
          </Table.Cell>
          <Table.Cell className="whitespace-nowrap p-4 text-base font-medium text-gray-900 dark:text-white">
            655.303.730-20
          </Table.Cell>
          <Table.Cell className="whitespace-nowrap p-4 text-base font-normal text-gray-900 dark:text-white">
            <div className="flex items-center">
                Pessoa Física
            </div>
          </Table.Cell>
          <Table.Cell>
            <div className="flex items-center gap-x-3 whitespace-nowrap">
              <EditUserModal />
              <DeleteUserModal />
            </div>
          </Table.Cell>
        </Table.Row>

      </Table.Body>
    </Table>
  );
};

const EditUserModal: FC = function () {
  const [isOpen, setOpen] = useState(false);

  return (
    <>
      <Button color="primary" onClick={() => setOpen(true)}>
        <div className="flex items-center gap-x-2">
          <HiOutlinePencilAlt className="text-lg" />
          Editar
        </div>
      </Button>
      <Modal onClose={() => setOpen(false)} show={isOpen}>
        <Modal.Header className="border-b border-gray-200 !p-6 dark:border-gray-700">
          <strong>Editar Cliente</strong>
        </Modal.Header>
        <Modal.Body>
          <div className="grid grid-cols-1 gap-6 sm:grid-cols-2">

            <div>
              <Label htmlFor="department">Tipo</Label>
              <div className="mt-1">
                <Select id="people" required>
                  <Label htmlFor="people-search" className="sr-only">
                      Pesquisar
                    </Label>
                    <option>
                      Pessoa Física
                    </option>
                    <option>
                      Pessoa Jurídica        
                    </option>
                </Select>
              </div>
            </div>

            <div>
              <Label htmlFor="name">Name</Label>
              <div className="mt-1">
                <TextInput
                  id="name"
                  name="name"
                  placeholder="Jardielma"
                  required
                  type="text"
                />
              </div>
            </div>

            <div>
              <Label htmlFor="mcc">MCC</Label>
              <div className="mt-1">
                <TextInput
                  id="mcc"
                  name="mcc"
                  placeholder="0014"
                  type="number"
                  required
                />
              </div>
            </div>

            <div>
              <Label htmlFor="CPF/CNPJ">CPF/CNPJ</Label>
              <div className="mt-1">
                <TextInput
                  id="cadastro_pessoa"
                  name="cadastro_pessoa"
                  placeholder="173.215.490-20"
                  type="number"
                  required
                />
              </div>
            </div>

            <div>
              <Label htmlFor="email">Email</Label>
              <div className="mt-1">
                <TextInput
                  id="email"
                  name="email"
                  placeholder="example@company.com"
                  type="email"
                  required
                />
              </div>
            </div>
            <div>
              <Label htmlFor="phone">Telefone</Label>
              <div className="mt-1">
                <TextInput
                  id="phone"
                  name="phone"
                  placeholder="(99) 9 9999-9999"
                  type="tel"
                  required
                />
              </div>
            </div>

          </div>
          <div className="my-5">
              <Label htmlFor="razao_social">Razão Social</Label>
              <div className="mt-1">
                <TextInput
                  id="razao_social"
                  name="razao_social"
                  placeholder="Razão Social"
                  sizing="lg"
                  type="text"
                />
              </div>
            </div>
        </Modal.Body>
        <Modal.Footer>
          <Button color="primary" onClick={() => setOpen(false)}>
            Salvar
          </Button>
        </Modal.Footer>
      </Modal>
    </>
  );
};

const DeleteUserModal: FC = function () {
  const [isOpen, setOpen] = useState(false);

  return (
    <>
      <Button color="failure" onClick={() => setOpen(true)}>
        <div className="flex items-center gap-x-2">
          <HiTrash className="text-lg" />
          Deletar
        </div>
      </Button>
      <Modal onClose={() => setOpen(false)} show={isOpen} size="md">
        <Modal.Header className="px-6 pt-6 pb-0">
          <span className="sr-only">Deletar</span>
        </Modal.Header>
        <Modal.Body className="px-6 pt-0 pb-6">
          <div className="flex flex-col items-center gap-y-6 text-center">
            <HiOutlineExclamationCircle className="text-7xl text-red-500" />
            <p className="text-xl text-gray-500">
            Tem certeza de que deseja excluir?
            </p>
            <div className="flex items-center gap-x-3">
              <Button color="failure" onClick={() => setOpen(false)}>
                Confirmar
              </Button>
              <Button color="gray" onClick={() => setOpen(false)}>
                cancelar
              </Button>
            </div>
          </div>
        </Modal.Body>
      </Modal>
    </>
  );
};

export const Pagination: FC = function () {
  return (
    <div className="sticky right-0 bottom-0 w-full items-center border-t border-gray-200 bg-white p-4 dark:border-gray-700 dark:bg-gray-800 sm:flex sm:justify-between">
    </div>
  );
};

export default UserListPage;
